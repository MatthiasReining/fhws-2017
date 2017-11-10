FROM jboss/wildfly
ADD target/fhws.war /opt/jboss/wildfly/standalone/deployments/
