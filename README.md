
# serverless
serverless framework

```bash
npm install -g serverless

# Create a new serverless project
# serverless or sls
serverless
 
# Move into the newly created directory
cd your-service-name

# Invoke and display logs:
sls invoke -f hello --log

# Tail logs
sls logs -f hello --tail

sls remove

# aws credentials
sls config credentials \
  --provider aws \
  --key AKIAIOSFODNN7EXAMPLE \
  --secret wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY

# deploy
sls deploy --stage production --region eu-central-1

# config from serverless.yml
sls deploy

# aws sam  vs serverless framework
https://www.techmagic.co/blog/serverless-framework-vs-aws-sam/

# java-aws-lambda-hibernate
https://www.baeldung.com/java-aws-lambda-hibernate

# aws-java-spring-cloud-function-demo
https://www.serverless.com/examples/aws-java-spring-cloud-function-demo
```