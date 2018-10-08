#!/bin/bash

# INIT DUMP EXECUTION
(
if test -n "$INIT_DUMP"; then
    echo "execute dump file"
	until mongo piggymetrics $INIT_DUMP; do sleep 5; done
fi
) &

echo "start mongodb without auth"
chown -R mongodb /data/db
gosu mongodb mongod "$@"
