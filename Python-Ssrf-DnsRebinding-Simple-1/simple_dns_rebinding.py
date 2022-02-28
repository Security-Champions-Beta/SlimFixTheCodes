import requests

from urllib.parse import urlparse
blocked_urls = ['127.0.0.1' , '169.254.169.254', 'localhost']
#blocked_urls = ['169.254.169.254']

#url = "http://mhnam.com:8000"

url = "http://b0x.mannulinux.org:8000"

parsed = urlparse(url).hostname
if parsed not in blocked_urls :
    varb = requests.get(url)
    print(varb.status_code)
else:
        print ("I cant connect and make requests")