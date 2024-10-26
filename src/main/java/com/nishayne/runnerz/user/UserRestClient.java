package com.nishayne.runnerz.user;

import com.nishayne.runnerz.run.JdbcClientRunRepository;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.List;

@Component
public class UserRestClient {

    private final RestClient restClient;

    public UserRestClient(RestClient.Builder builder) {
//        JdbcClientHttpRequestFactory jdbcClientHttpRequestFactory= new JdbcClientHttpRequestFactory();
//        jdbcClientHttpRequestFactory.setReadTimeout(5000);
        this.restClient = builder
                .baseUrl("https://jsonplaceholder.typicode.com/")
//                .requestFactory(jdbcClientHttpRequestFactory)
                .build();
    }

    public List<User> findAll() {
        return restClient.get()
                .uri("/users")
                .retrieve()
                .body(new ParameterizedTypeReference<>() {});
        }
        public User findById(Integer id){
            return restClient.get()
                    .uri("/users/{id}",id)
                    .retrieve()
                    .body(User.class);
        }
    }
