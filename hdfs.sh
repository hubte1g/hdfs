# Recursibely list file in hdfs by size
hdfs dfs -ls -R / | sort -r -n -k 5

# By top 10
hdfs dfs -ls -R /kohls/eim/ | sort -r -n -k 5 | head -10
