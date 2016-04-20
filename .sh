%sh
cat '\\windows\file.txt'

%scp
# Absolute path and file name hardcoded, to be parameterized future. If is not used will inherit \\path\filename.ext from Windows
scp -P 2225 '\\windows\file.txt' tkb2171@127.0.1.2:home/folder/file.txt

%hdfs
# Create directory in HDFS using absolute URI
hdfs dfs -mkdir hdfs://HDFS/dir
hdfs dfs -chmod 777 h hdfs://HDFS/dir

# Put file to HDFS directory and read first n lines
hdfs dfs -put home/folder/file.txt hdfs://HDFS/dir
hdfs dfs -cat  hdfs dfs -cat  hdfs://HDFS/dir/file.txt | head -10

%pyspark
pyspark

%py
rvws_raw = sc.textFile("hdfs://HDFS/dir/file.txt")
rvws_raw.map(lambda x: x.split(' ')).collect()
rvws_raw.flatMap(lambda x: x.split(' ')).collect()
