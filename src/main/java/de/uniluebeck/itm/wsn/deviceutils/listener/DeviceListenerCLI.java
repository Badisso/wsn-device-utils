/**********************************************************************************************************************
 * Copyright (c) 2010, Institute of Telematics, University of Luebeck                                                 *
 * All rights reserved.                                                                                               *
 *                                                                                                                    *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the   *
 * following conditions are met:                                                                                      *
 *                                                                                                                    *
 * - Redistributions of source code must retain the above copyright notice, this list of conditions and the following *
 *   disclaimer.                                                                                                      *
 * - Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the        *
 *   following disclaimer in the documentation and/or other materials provided with the distribution.                 *
 * - Neither the name of the University of Luebeck nor the names of its contributors may be used to endorse or        *
 *   promote products derived from this software without specific prior written permission.                           *
 *                                                                                                                    *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, *
 * INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE      *
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,         *
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE *
 * GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF    *
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY   *
 * OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.                                *
 **********************************************************************************************************************/

package de.uniluebeck.itm.wsn.deviceutils.listener;

import com.google.common.base.Joiner;
import de.uniluebeck.itm.tr.util.Logging;
import de.uniluebeck.itm.wsn.deviceutils.listener.writers.CsvWriter;
import de.uniluebeck.itm.wsn.deviceutils.listener.writers.HumanReadableWriter;
import de.uniluebeck.itm.wsn.deviceutils.listener.writers.WiseMLWriter;
import de.uniluebeck.itm.wsn.deviceutils.listener.writers.Writer;
import de.uniluebeck.itm.wsn.drivers.core.Connection;
import de.uniluebeck.itm.wsn.drivers.core.Device;
import de.uniluebeck.itm.wsn.drivers.factories.ConnectionFactoryImpl;
import de.uniluebeck.itm.wsn.drivers.factories.DeviceFactoryImpl;
import org.apache.commons.cli.*;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class DeviceListenerCLI {

	private final static Level[] LOG_LEVELS = {Level.TRACE, Level.DEBUG, Level.INFO, Level.WARN, Level.ERROR};

	private final static org.slf4j.Logger log = LoggerFactory.getLogger(DeviceListenerCLI.class);

	public static void main(String[] args) throws InterruptedException, IOException {

		Logging.setLoggingDefaults();

		CommandLineParser parser = new PosixParser();
		Options options = createCommandLineOptions();

		String deviceType = null;
		String port = null;

		OutputStream outStream = System.out;
		Writer outWriter = null;

		try {

			CommandLine line = parser.parse(options, args);

			if (line.hasOption('h')) {
				printUsageAndExit(options);
			}

			if (line.hasOption('v')) {
				Logger.getRootLogger().setLevel(Level.DEBUG);
			}

			if (line.hasOption('l')) {
				Level level = Level.toLevel(line.getOptionValue('l'));
				Logger.getRootLogger().setLevel(level);
			}

			deviceType = line.getOptionValue('t');
			port = line.getOptionValue('p');

			if (line.hasOption('o')) {
				String filename = line.getOptionValue('o');
				log.info("Using outfile {}", filename);
				outStream = new FileOutputStream(filename);
			}

			if (line.hasOption('f')) {

				String format = line.getOptionValue('f');

				if ("csv".equals(format)) {
					outWriter = new CsvWriter(outStream);
				} else if ("wiseml".equals(format)) {
					outWriter = new WiseMLWriter(outStream, "node at " + line.getOptionValue('p'), true);
				} else {
					throw new Exception("Unknown format " + format);
				}

				log.info("Using format {}", format);

			} else {
				outWriter = new HumanReadableWriter(outStream);
			}

		} catch (Exception e) {
			log.error("Invalid command line: " + e);
			printUsageAndExit(options);
		}

		final Writer finalOutWriter = outWriter;
		Runtime.getRuntime().addShutdownHook(new Thread(DeviceListenerCLI.class.getName() + "-ShutdownThread") {
			@Override
			public void run() {
				try {
					finalOutWriter.shutdown();
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
		}
		);

		final Connection connection = new ConnectionFactoryImpl().create(deviceType);
		connection.connect(port);

		if (!connection.isConnected()) {
			throw new RuntimeException("Connection to device at port \"" + args[1] + "\" could not be established!");
		}

		final Device<? extends Connection> device = new DeviceFactoryImpl().create(deviceType, connection);

		// TODO attach netty and fragment decoders to device InputStream and print to writer

	}

	private static Options createCommandLineOptions() {

		Options options = new Options();

		// add all available options
		options.addOption("p", "port", true, "Serial port to use");
		options.getOption("p").setRequired(true);
		options.addOption("t", "type", true, "Device type");
		options.getOption("t").setRequired(true);

		options.addOption("f", "format", true, "Optional: Output format, options: csv, wiseml");
		options.addOption("o", "outfile", true, "Optional: Redirect output to file");
		options.addOption("v", "verbose", false, "Optional: Verbose logging output (equal to -l DEBUG)");
		options.addOption("l", "logging", true,
				"Optional: Set logging level (one of [" + Joiner.on(", ").join(LOG_LEVELS) + "])"
		);
		options.addOption("h", "help", false, "Help output");

		return options;
	}

	private static void printUsageAndExit(Options options) {
		HelpFormatter formatter = new HelpFormatter();
		formatter.printHelp(120, DeviceListenerCLI.class.getCanonicalName(), null, options, null);
		System.exit(1);
	}
}