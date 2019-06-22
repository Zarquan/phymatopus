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

package uk.ac.roe.wfau.phymatopus.kafka.cassandra;

import org.springframework.beans.factory.annotation.Value;

import lombok.extern.slf4j.Slf4j;
import uk.ac.roe.wfau.phymatopus.kafka.alert.ZtfAlert;
import uk.ac.roe.wfau.phymatopus.kafka.tools.ZtfAbstractReaderTest;

/**
 *
 *
 */
@Slf4j
public abstract class ZtfCassandraWriterTest
extends ZtfAbstractReaderTest
    {
    /**
     * Our Cassandrda connection hostname.
     * 
     */
    @Value("${phymatopus.cassandrda.hostname:}")
    private String hostname ;

    /**
     * Our Cassandrda connection hostname.
     * 
     */
    public String hostname()
        {
        return this.hostname;
        }

    /**
     * Our Cassandrda datacenter name.
     * 
     */
    @Value("${phymatopus.cassandrda.dcname:}")
    private String dcname;

    /**
     * Our Cassandrda datacenter name.
     * 
     */
    public String dcname()
        {
        return this.dcname;
        }
    
    /**
     * Public constructor.
     *
     */
    public ZtfCassandraWriterTest()
        {
        super();
        }
    
    /**
     * Our Alert processor class.
     * 
     */
    public class Processor implements ZtfAlert.Processor
        {
        private long count ;
        public long count()
            {
            return this.count;
            }

        private AbstractCassandraWriter writer;
        
        /**
         * Public constructor.
         * 
         */
        public Processor(AbstractCassandraWriter writer)
            {
            this.writer = writer;
            writer.init();
            }

        @Override
        public void process(final ZtfAlert alert)
            {
            this.count++;
            log.trace("Candidate [{}][{}]", this.count, alert.getCandid());
            writer.process(
                alert
                );
            }
        }

    /**
     * Create a new alert processor.
     * 
     */
    public Processor processor()
        {
        return new Processor(
            this.writer()
            ); 
        }

    /**
     * Create a new alert writer.
     * 
     */
    public abstract AbstractCassandraWriter writer();
    
    }
