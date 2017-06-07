#!/bin/sh

if [ $# -lt 1 ]; then
  echo "Usage: $0 [p|pre|t|d]";
  exit;
fi

case $1 in
  d | devleopment)
    env="dev"
    ;;
  t | test)
    env="test"
    ;;
  pre | pre_production)
    env="pre"
    ;;
  p | production)
    env="pro"
    ;;
  *) echo "输入有误！请重新输入！"
    echo
    ;;
esac

export MAVEN_OPTS="-Xmx512m -XX:MaxPermSize=128m"

mvn clean install -Dmaven.test.skip=true -Denv=$env -e

