#!/bin/bash
#
#

COLOR_RED='\033[31m'
COLOR_YELLOW='\033[33m'
COLOR_GREEN='\033[32m'
COLOR_BLUE='\033[1;34m'
COLOR_RESET='\033[0m'

PROJECT='php xxe lfi'
PORT=10004
TRIES=480
LOADING=0

printf "${COLOR_YELLOW}XXE!\n${COLOR_RESET}"

while : ; do
    `curl -s -f http://localhost:$PORT > /dev/null`
    if [ $? == 0 ] ; then
        break
    fi
    if [ $TRIES == 0 ] ; then
        break
    fi
    TRIES=$((TRIES-1))
	sleep 0.25 

    # Loading animation
    if [ $LOADING == 14 ]; then
        LOADING=0
    fi
    if [ $LOADING == 0 ]; then
        printf "\r${COLOR_YELLOW} XXE: 👀  Your app is still starting... (*-------) ${COLOR_RESET}"
    elif [ $LOADING == 1 ]; then
	    printf "\r${COLOR_YELLOW}XXE: 👀  Your app is still starting... (-*------) ${COLOR_RESET}"
    elif [ $LOADING == 2 ]; then
        printf "\r${COLOR_YELLOW}XXE: 👀  Your app is still starting... (--*-----) ${COLOR_RESET}"
    elif [ $LOADING == 3 ]; then
        printf "\r${COLOR_YELLOW}XXE: 👀  Your app is still starting... (---*----) ${COLOR_RESET}"
    elif [ $LOADING == 4 ]; then
        printf "\r${COLOR_YELLOW}XXE: 👀  Your app is still starting... (----*---) ${COLOR_RESET}"
    elif [ $LOADING == 5 ]; then
        printf "\r${COLOR_YELLOW}XXE: 👀  Your app is still starting... (-----*--) ${COLOR_RESET}"
    elif [ $LOADING == 6 ]; then
        printf "\r${COLOR_YELLOW}XXE: 👀  Your app is still starting... (------*-) ${COLOR_RESET}"
    elif [ $LOADING == 7 ]; then
        printf "\r${COLOR_YELLOW}XXE: 👀  Your app is still starting... (-------*) ${COLOR_RESET}"
    elif [ $LOADING == 8 ]; then
        printf "\r${COLOR_YELLOW}XXE: 👀  Your app is still starting... (------*-) ${COLOR_RESET}"
    elif [ $LOADING == 9 ]; then
        printf "\r${COLOR_YELLOW}XXE: 👀  Your app is still starting... (-----*--) ${COLOR_RESET}"
    elif [ $LOADING == 10 ]; then
        printf "\r${COLOR_YELLOW}XXE: 👀  Your app is still starting... (----*---) ${COLOR_RESET}"
    elif [ $LOADING == 11 ]; then
        printf "\r${COLOR_YELLOW}XXE: 👀  Your app is still starting... (---*----) ${COLOR_RESET}"
    elif [ $LOADING == 12 ]; then
        printf "\r${COLOR_YELLOW}XXE: 👀  Your app is still starting... (--*-----) ${COLOR_RESET}"
    elif [ $LOADING == 13 ]; then
        printf "\r${COLOR_YELLOW}XXE: 👀  Your app is still starting... (-*------) ${COLOR_RESET}"
    fi
    LOADING=$((LOADING+1))
    # End of loading animation

done

if [ $TRIES == 0 ]; then
    printf "\n${COLOR_RED}XXE: Ooops! Something went wrong, please check api details for more information!\n${COLOR_RESET}"
else
    printf "\n${COLOR_GREEN}XXE: 🔥  ${PROJECT} is now running at ${COLOR_RESET}${COLOR_BLUE}http://localhost:$PORT${COLOR_RESET}\n"
fi
