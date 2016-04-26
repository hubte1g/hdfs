//package com.informatica.hadoop;

import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import java.util.Map;
import org.apache.hadoop.security.*;

public class HDFSClient {
                
                public static void main(String[] args) throws Exception {
//                            String uri =  	;                        
//                            readFile(uri);
                	int startInt = 0;
                	int NUM_RECORDS = 100000;
                	 for (int line = 0; line <  1; ++line){
                                String uri = "host---:50470/" + line +".txt";
                                createLargeAggregateSalesInputFile(uri,startInt, NUM_RECORDS);
                                startInt= startInt +1000;
                	 }
                }
                
                public static void readFile(String uri) throws Exception {
                                Configuration conf = new Configuration();
                                FileSystem fs      = FileSystem.get(URI.create(uri), conf);
                                InputStream in     = null;
                                
                                try {
                                                in = fs.open(new Path(uri));
                                                
                                                long t1 = System.currentTimeMillis();                                    
                                                IOUtils.copyBytes(in, new IOUtils.NullOutputStream(), 4096, false);
                                                long t2 = System.currentTimeMillis();
                                                
                                                System.err.println("Read [" + uri + "] in [" + (t2-t1) + "]ms..");
                                                
                                } finally {
                                                IOUtils.closeStream(in);
                                }                              
                }
                
                public static void createLargeAggregateSalesInputFile(String uri, int startInt, int NUM_RECORDS) throws Exception {
                                Configuration conf    = new Configuration();
                                  conf.addResource("hive-site.xml");
                                  UserGroupInformation.setConfiguration(conf);

            //    for (Map.Entry<String,String> entry : conf) {
            //    System.out.println("Key/Value: " + entry.getKey() + "/" + entry.getValue());
            //    }


                        //   UnixUserGroupInformation userInfo = new UnixUserGroupInformation("aphdp", new String[]{"supergroup"});
                    		//UnixUserGroupInformation.saveToConf(conf, "hadoop.job.ugi", userInfo);
                    			
                               System.out.println("URL: " + uri);
                                FileSystem fs         = FileSystem.get(URI.create(uri), conf);
                               System.out.println("After FileSystem.get");
                                OutputStream out      = null;
                                final int BUFFER_SIZE = 10;
                               
                                int Total_NUM_RECORDS = NUM_RECORDS + startInt;

                                
                                // salim   2       cisco   2000
                                
                                try {
                               System.out.println("before fs.create");
                                                out = new BufferedOutputStream(fs.create(new Path(uri)), BUFFER_SIZE); 
                               System.out.println("After fs.create");
                                                System.err.println("Created HDFS file [" + uri + "]..");
                                                
                                                long t1 = System.currentTimeMillis();                                    
                        for (int line = startInt; line <  Total_NUM_RECORDS; ++line) {
                                StringBuilder builder = new StringBuilder();
                                
                                builder.append("shanker,");
                                builder.append(line);
                                builder.append(",");
                                builder.append(line);
                                builder.append(",");
                                builder.append("INFA-");
                                builder.append(line);
                                builder.append(",");
                                builder.append(line);
                                builder.append("\n");
                                
                                out.write(builder.toString().getBytes());
                                
                                if ((line % 100000) == 0) {
                                                System.err.println("Wrote [" + line + "] records in [" + (System.currentTimeMillis()-t1) + "]ms..");
                                }
                                
                        }
                        out.flush();
                        
                                                long t2 = System.currentTimeMillis();
                                                
                                                System.err.println("\n\n*** Wrote [" + NUM_RECORDS + "] records in [" + uri + "] file in [" + (t2-t1) + "]ms..");
                                                
                                } finally {
                                                IOUtils.closeStream(out);
                                }                              
                                

                                
                }
                
                public void dummy (){}
                

}

