package com.arjunagi.basicinsta.repo;

import com.arjunagi.basicinsta.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPostRepo extends JpaRepository<Post,Integer> {
}
