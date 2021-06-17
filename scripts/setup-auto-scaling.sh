#!/bin/bash

cf cs app-autoscaler standard pal-tracker-autoscaler
cf bs pal-traker pal-tracker-autoscaler
cf update-autoscaling-limits pal-traker 3 5
cf create-autoscaling-rule pal-traker http_throughput 5 10
cf enable-autoscaling pal-traker
