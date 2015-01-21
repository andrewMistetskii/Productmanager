package yuri.misyac.productmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yuri.misyac.productmanager.dao.DocumentDAO;
import yuri.misyac.productmanager.entity.Document;

import java.util.List;

@Service
public class DocumentService {

    @Autowired
    private DocumentDAO documentDAO;

    @Transactional
    public void addDocument(Document document) {
        documentDAO.addDocument(document);
    }

    @Transactional
    public List<Document> documentList() {
        return documentDAO.documentList();
    }
}
