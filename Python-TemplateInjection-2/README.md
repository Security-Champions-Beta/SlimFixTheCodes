# Python-Jinja-TemplateInj2

If the app blindly takes a user input (such as username) and render it into a template. Then the user can inject arbitrary code which the template will evaluate.

Such injection, will allow the user to access some APIs and methods which are not supposed to.

**How to discover the flaw❓**

Usually manually, with trial and error. If we don’t know the type of the template engine, then we inject a set of various template syntax. Portswigger provides an extensive approach to spot the vulnerability with different template types.

For this demo, I will be using Python and Jinja template.

In Jinja, 

    if you pass an operation like {{7*7}} and the app evaluated 7*7 and returned 49


Jinja2 is a full featured template engine for Python. It has full unicode support, an optional integrated sandboxed execution environment, widely used and BSD licensed.

            {{7*7}} = Error
            ${7*7} = ${7*7}
            {{foobar}} Nothing
            {{4*4}}[[5*5]]
            {{7*'7'}} = 7777777
            {{config}}
            {{config.items()}}
            {{settings.SECRET_KEY}}
            {{settings}}
            {% debug %}
            
## Owasp

https://owasp.org/www-project-web-security-testing-guide/v41/4-Web_Application_Security_Testing/07-Input_Validation_Testing/18-Testing_for_Server_Side_Template_Injection

## PortSwigger

https://portswigger.net/web-security/server-side-template-injection#constructing-a-server-side-template-injection-attack

## SAST Tools : 


Find With SAST Tools : Sonar Develper plans


![Getting Started](68.png)



Find With SAST Tools : Snyk Enterprise plans

![Getting Started](69.png)




## Setup

install from my dockerhub : https://hub.docker.com/r/mhnamadi/noorassti


    docker run -itd -p 9090:60 mhnamadi/noorassti python /root/vulncode.py


## Payload 

    https://github.com/swisskyrepo/PayloadsAllTheThings/blob/master/Server%20Side%20Template%20Injection/Intruder/ssti.fuzz

## Attack HELP

    http://blog.portswigger.net/2015/08/server-side-template-injection.html
    https://github.com/epinna/tplmap/issues/9
    http://disse.cting.org/2016/08/02/2016-08-02-sandbox-break-out-nunjucks-template-engine
    https://artsploit.blogspot.co.uk/2016/08/pprce2.html
    http://jinja.pocoo.org/
    http://flask.pocoo.org/
    https://opsecx.com/index.php/2016/07/03/server-side-template-injection-in-tornado/



![Getting Started](66.png)

## Fix Guide :  

![Getting Started](67.png)


## Contributing : 
 
We encourage you to contribute to Project

## Twitter & Facebook Contributor :

https://www.linkedin.com/in/mohammad-hussein-namadi-775baa131/

Twitter : @Dmitriy_area51

LinkedIn : https://www.linkedin.com/in/omid-shojaei


## Fix 

We encourage you to contribute to Project and Fix Codes

If you want to pull request please follow this :

CONTRIBUTION.md
  
## Report 


1. https://hackerone.com/reports/125980
2. https://hackerone.com/reports/230232
3. https://hackerone.com/reports/423541
4. https://hackerone.com/reports/399462
5. https://twitter.com/albinowax/status/718014765113741317
6. https://clement.notin.org/blog/2020/04/15/Server-Side-Template-Injection-/(SSTI/)-in-ASP.NET-Razor/
7. https://mahmoudsec.blogspot.com/2019/04/handlebars-template-injection-and-rce.html
8. https://infosecwriteups.com/leveraging-template-injection-to-takeover-an-account-1dba7c4ae315
9. https://cyc10n3.medium.com/rce-via-server-side-template-injection-ad46f8e0c2ae
10. https://infosecwriteups.com/reflected-xss-on-microsoft-com-via-angular-template-injection-2e26d80a7fd8
11. https://blog.securitybreached.org/2020/03/31/microsoft-rce-bugbounty/
12. https://akshukatkar.medium.com/rce-with-flask-jinja-template-injection-ea5d0201b870
13. https://mahmoudsec.blogspot.com/2019/04/handlebars-template-injection-and-rce.html
14. https://infosecwriteups.com/frapp%C3%A9-technologies-erpnext-server-side-template-injection-74e1c95ec872
15. http://ha.cker.info/exploitation-of-server-side-template-injection-with-craft-cms-plguin-seomatic/
16. https://web.archive.org/web/20201207232241/https://www.mohamedharon.com/2018/01/reflected-xss-possible-server-side.html
17. https://ackcent.com/in-depth-freemarker-template-injection/
18. [Reflected XSS and Server Side Template Injection  in all HubSpot CMSes](https://hackerone.com/reports/399462) to HubSpot - 61 upvotes, $0
19. XSS in $shop$.myshopify.com/admin/ via twine template injection in "Shopify.API.Modal.input" method when using a malicious app to Shopify - 31 upvotes, $1000
20. https://hackerone.com/reports/164224
21. https://hackerone.com/reports/250837
22. https://hackerone.com/reports/904672







