##
## Build
##

FROM golang:1.19-buster AS build

ENV CGO_ENABLED=0
# Single thread only
ENV GOMAXPROCS=1

WORKDIR /app

COPY go.mod /app/
#COPY go.sum /app/
COPY Makefile /app/

#RUN go mod download
#RUN go mod verify

COPY *.go /app/

RUN make

##
## Deploy
##

FROM gcr.io/distroless/base-debian10

WORKDIR /

COPY --from=build /app/go-api /go-api

EXPOSE 4000

USER nonroot:nonroot

ENTRYPOINT ["/go-api"]
