package org.example.logs;
/*
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import com.datastax.oss.driver.api.core.CqlSession;

import java.net.InetSocketAddress;

@Configuration
@EnableCassandraRepositories(basePackages = "org.example.logs")
public class CassandraConfig extends AbstractCassandraConfiguration {

    @Override
    protected String getKeyspaceName() {
        return "flight_logs";  // Подключаемся к нужному keyspace
    }

    @Override
    protected String getContactPoints() {
        return "localhost";  // Адрес кластера Cassandra
    }

    @Override
    protected int getPort() {
        return 9042;  // Порт по умолчанию
    }

    // Используем CqlSession вместо CassandraSession
    @Bean
    public CqlSession cqlSession() {
        return CqlSession.builder()
                .addContactPoint(new InetSocketAddress("localhost", 9042))
                .withKeyspace(getKeyspaceName())
                .build();
    }

    // Создаем CassandraTemplate с использованием CqlSession
    @Bean
    public CassandraTemplate cassandraTemplate(CqlSession cqlSession) {
        return new CassandraTemplate(cqlSession);
    }
}

 */