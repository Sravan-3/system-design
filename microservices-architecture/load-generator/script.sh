#!/bin/bash

URL="http://localhost:8080/order"

while true; do
    seq 1 500 | xargs -P 1000 -I{} bash -c '
    curl -s "'"$URL"'?productId=$((RANDOM%3+1))&qty=1" > /dev/null
  '
done
