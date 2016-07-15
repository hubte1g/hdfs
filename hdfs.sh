# Recursibely list file in hdfs by size
hdfs dfs -ls -R / | sort -r -n -k 5

# By top 10
hdfs dfs -ls -R /dir/dir_/ | sort -r -n -k 5 | head -10

# count lines in part file
hdfs dfs -cat /dir/dir_/dir__/dir___/dir____/part-m-00000 | wc -l

# display hdfs as tree
hadoop fs -lsr /dir | awk '{print $8}' | sed -e 's/[^-][^\/]*\//--/g' -e 's/^/ /' -e 's/-/|/'

