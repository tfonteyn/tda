#!/bin/sh
# Unix shell script for starting tda. If you have big log files
# you might need to adjzst Xmx setting.

cd $(dirname $(readlink -f $0))/..; java -Xmx512m -jar ./tda.jar 
