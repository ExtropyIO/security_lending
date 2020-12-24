#!/bin/bash
if [ -z $1 ] || [ ! -f $1 ]; then
  echo "Please provide a valid script file to execute as the first parameter (i.e. private_contract.js)" >&2
  exit 1
fi
BIN_GETH='/Users/Kirsty/.quorum-wizard/bin/quorum/20.10.0/geth'
BIN_TESSERA='/Users/Kirsty/.quorum-wizard/bin/tessera/0.11.0/tessera-app.jar'

"$BIN_GETH" --exec "loadScript(\"$1\")" attach qdata/dd1/geth.ipc
