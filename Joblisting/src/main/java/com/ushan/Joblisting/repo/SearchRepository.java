package com.ushan.Joblisting.repo;

import com.ushan.Joblisting.model.Post;

import java.util.List;

public interface SearchRepository {

     List<Post> findByText(String text);

}
