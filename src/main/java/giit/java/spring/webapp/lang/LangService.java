package giit.java.spring.webapp.lang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
class LangService {
    private final Logger logger = LoggerFactory.getLogger(LangService.class);

    private LangRepository repository;

    LangService(LangRepository repository) {
        this.repository = repository;
    }

    List<LangDTO> findAll() {
        return repository
                .findAll()
                .stream()
                .map(LangDTO::new)
                .collect(toList());
    }
}
