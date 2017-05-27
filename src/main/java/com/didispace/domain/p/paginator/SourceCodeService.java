package com.didispace.domain.p.paginator;

import com.didispace.domain.p.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class SourceCodeService {
    @Autowired
    private PageRepository pageRepository;

    public Page<User> getSourceCode(int pageNumber,int pageSize){
        PageRequest request = this.buildPageRequest(pageNumber,pageSize);
        Page<User> uCodes= this.pageRepository.findAll(request);
        return uCodes;
    }

    //构建PageRequest
    private PageRequest buildPageRequest(int pageNumber, int pagzSize) {
        return new PageRequest(pageNumber - 1, pagzSize, null);
    }

}