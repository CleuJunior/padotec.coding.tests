FROM rabbitmq:3.9-alpine

RUN set eux; \
	rabbitmq-plugins enable --offline rabbitmq_management; \
	rm -f /etc/rabbitmq/conf.d/management_agent.disable_metrics_collector.conf; \

	cp /plugins/rabbitmq_management-*/priv/www/cli/rabbitmqadmin /usr/local/bin/rabbitmqadmin; \
	[ -s /usr/local/bin/rabbitmqadmin ]; \
	chmod +x /usr/local/bin/rabbitmqadmin; \
	apk add --no-cache python3; \
	rabbitmqadmin --version

EXPOSE 15671 15671