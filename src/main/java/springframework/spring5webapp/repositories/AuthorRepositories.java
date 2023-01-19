package springframework.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import springframework.spring5webapp.domain.Author;

public interface AuthorRepositories extends CrudRepository <Author, Long>{
}
