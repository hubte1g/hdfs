204  2016-08-09 07:42:11 final_table_path=`executeHiveQuery -e "describe extended db_.raw_TBLF" | perl -n -e'while(/(\w*location:hdfs:\/\/\w*\/[0-9a-zA-Z\/_=\.]*)/g) {print "$1\n"}' | tr -s ' ' | cut -d ':' -f2,3`

205  2016-08-09 07:42:29 final_table_path=`hive -e "describe extended db_.raw_TBL" | perl -n -e'while(/(\w*location:hdfs:\/\/\w*\/[0-9a-zA-Z\/_=\.]*)/g) {print "$1\n"}' | tr -s ' ' | cut -d ':' -f2,3`

206  2016-08-09 07:42:42 final_table_path=`hive -e "describe extended db_.raw_TBL" | perl -n -e'while(/(\w*location:hdfs:\/\/\w*\/[0-9a-zA-Z\/_=\.]*)/g) {print "$1\n"}' | tr -s ' ' | cut -d ':' -f2,3`

209  2016-08-09 07:44:01 final_table_path=`hive -e "describe extended db_.raw_TBL" | perl -n -e'while(/(\w*location:hdfs:\/\/\w*\/[0-9a-zA-Z\/_=\.]*)/g) {print "$1\n"}' | tr -s ' ' | cut -d ':' -f2,3`

211  2016-08-09 07:44:39 final_table_path=`hive -e "describe extended db_.raw_TBL" | perl -n -e'while(/(\w*location:hdfs:\/\/\w*\/[0-9a-zA-Z\/_=\.]*)/g) {print "$1\n"}' | tr -s ' ' | cut -d ':' -f2,3`

213  2016-08-09 07:45:14 final_table_path=`hive -e "describe extended db_.raw_TBL" | perl -n -e'while(/(\w*location:hdfs:\/\/\w*\/[0-9a-zA-Z\/_=\.]*)/g) {print "$1\n"}' | tr -s ' ' | cut -d ':' -f2,3`
