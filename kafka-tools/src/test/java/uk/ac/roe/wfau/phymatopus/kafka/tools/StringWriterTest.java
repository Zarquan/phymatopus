/*
 *  Copyright (C) 2018 Royal Observatory, University of Edinburgh, UK
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package uk.ac.roe.wfau.phymatopus.kafka.tools;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;
import uk.ac.roe.wfau.phymatopus.kafka.alert.ZtfAlert.Processor;

/**
 * 
 * 
 */
@Slf4j
public class StringWriterTest
extends ZtfAbstractReaderTest 
    {

    /**
     * 
     */
    public StringWriterTest()
        {
        super();
        }

    /**
     * Test our {@link StringWriter}.
     * 
     */
    @Test
    public void write()
        {
        log.debug("Write test ..");
        final StringWriter writer = new StringWriter(
            new BaseClient.ConfigurationBean(
                servers,
                topic
                )
            ); 
        writer.write(
            10000
            );
        }

    @Override
    public Processor processor()
        {
        // TODO Auto-generated method stub
        return null;
        }
    }
