#!/bin/bash

cf disable-autoscaling pal-traker
cf unbind-service pal-traker pal-tracker-autoscaler
cf ds pal-tracker-autoscaler -f
cf scale pal-traker -i 3
