/**
 * 
 */
package uk.ac.roe.wfau.phymatopus.avro.file;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;
import uk.ac.roe.wfau.phymatopus.alert.AlertProcessor;
import uk.ac.roe.wfau.phymatopus.alert.AlertReader.ReaderStatistics;
import uk.ac.roe.wfau.phymatopus.alert.BaseAlert;

/**
 *
 *
 */

@Slf4j
@RunWith(
        SpringJUnit4ClassRunner.class
        )
@ContextConfiguration(
    locations = {
        "classpath:component-config.xml"
        }
    )
public class ZtfTarGzipReaderTestCase
    {
    /**
    *
    */
   public ZtfTarGzipReaderTestCase()
       {
       }

   protected AlertProcessor<BaseAlert> processor()
       {
       return new AlertProcessor<BaseAlert>()
           {
           private long count ;
           @Override
           public long count()
               {
               return this.count;
               }
           @Override
           public void process(final BaseAlert alert)
               {
               count++;
               log.trace("candId    [{}]", alert.getCandid());
               log.trace("objectId  [{}]", alert.getObjectId());
               log.trace("schemavsn [{}]", alert.getSchemavsn().toString());
               }
           };
       }

   @Test
   public void testSomething()
       {
       ZtfTarGzipReader reader = new ZtfTarGzipReader(
           this.processor(),
           "/var/local/projects/LSST-UK/phymatopus/data/archive/ztf_public_20191206.tar.gz"
           );

       ReaderStatistics stats = reader.loop();
       
       log.debug("Read [{}] in [{}]", stats.count(), stats.time());

       }
    }
