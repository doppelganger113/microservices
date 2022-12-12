SHELL = /bin/bash
PROJECTNAME=go-api

GOBASE=$(shell pwd)
GOBIN=bin

TZ=UTC
APP_BUILD_DATE=$(shell date +%c)
GIT_COMMIT_SHA=$(shell git rev-list -1 HEAD)

default:
	go build -v -o $(PROJECTNAME) main.go || exit