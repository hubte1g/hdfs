# Recursibely list file in hdfs by size
hdfs dfs -ls -R / | sort -r -n -k 5
