package main

import (
	"fmt"
	"log"
	"net/http"
)

func hello(w http.ResponseWriter, req *http.Request) {
	log.Println("Hello request triggered")
	fmt.Fprintf(w, "hello\n")
}

func printHeaders(w http.ResponseWriter, req *http.Request) {
	log.Println("printing headers")
	for name, headers := range req.Header {
		for _, h := range headers {
			fmt.Fprintf(w, "%v: %v\n", name, h)
		}
	}
}

func main() {
	http.HandleFunc("/hello", hello)
	http.HandleFunc("/headers", printHeaders)

	log.Println("Server started on port :4000")
	if err := http.ListenAndServe(":4000", nil); err != nil {
		log.Println(err)
	}
}
