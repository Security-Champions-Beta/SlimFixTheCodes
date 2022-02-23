.SILENT:
.DEFAULT_GOAL := help

COLOR_RESET = \033[0m
COLOR_COMMAND = \033[36m
COLOR_YELLOW = \033[33m
COLOR_GREEN = \033[32m
COLOR_RED = \033[31m

PROJECT := XXE
PORT := 10004
SLEEPUNTILAPPSTARTS := 5

## Installs a development environment
install: compose msg

## Composes project using docker-compose
compose:
	docker-compose -f deployments/docker-compose.yml down -v --remove-orphans
	docker-compose -f deployments/docker-compose.yml up -d --build --force-recreate

## Prints initialization message after compose phase
msg:
	chmod +x deployments/check-init.sh
	./deployments/check-init.sh

## Prints help message
help:
	printf "\n${COLOR_YELLOW}${PROJECT}\n------\n${COLOR_RESET}"
	awk '/^[a-zA-Z\-\_0-9\.%]+:/ { \
		helpMessage = match(lastLine, /^## (.*)/); \
		if (helpMessage) { \
			helpCommand = substr($$1, 0, index($$1, ":")); \
			helpMessage = substr(lastLine, RSTART + 3, RLENGTH); \
			printf "${COLOR_COMMAND}$$ make %s${COLOR_RESET} %s\n", helpCommand, helpMessage; \
		} \
	} \
	{ lastLine = $$0 }' $(MAKEFILE_LIST) | sort
	printf "\n"

## Validate if app is vulnerable to the attack narrative
check-sec:
	chmod +x deployments/check-sec.sh
	./deployments/check-sec.sh