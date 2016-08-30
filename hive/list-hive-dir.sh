 hive -S -e "describe formatted eiv_sls_trn_sku_agg ;" | grep 'Location' | awk '{ print $NF }'
