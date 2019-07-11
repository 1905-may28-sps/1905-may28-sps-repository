# Auto Scaling Groups
* Feature in Amazon EC2 service
* Let's you automatically scale instances
  * Replace terminated instances
  * Increment number of instances based on metrics (CPU Utilization)
  * Decrement number of instances based on metrics

# Security Group
* Make sure DMZ security group allows port 80

# Launch Configuration
* Specify how to create VMs

boot script

```
#!/bin/bash

sudo yum install -y nginx

sudo service nginx start
sudo chkconfig nginx on
```

# Auto Scaling Group
* Specify how to scale VMs
