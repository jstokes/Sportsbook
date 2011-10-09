package sportsbook.dao;


public interface AbstractDAO<DomainObject, KeyType> {
    public DomainObject get(KeyType id);

    public void post(DomainObject obj);
}
