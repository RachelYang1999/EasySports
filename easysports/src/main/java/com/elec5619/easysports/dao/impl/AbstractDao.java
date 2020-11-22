package com.elec5619.easysports.dao.impl;

import com.mysql.cj.SimpleQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.LinkedList;
import java.util.List;

@Transactional(readOnly = false)
public abstract class AbstractDao <PK extends Serializable, T> extends HibernateDaoSupport {

    @Autowired
    public void setMySessionFactory(SessionFactory sessionFactory){
        super.setSessionFactory(sessionFactory);
    }

    private final Class<T> persistentClass;

    public AbstractDao(){
        ParameterizedType superclass = (ParameterizedType)this.getClass().getGenericSuperclass();
        this.persistentClass =(Class<T>) superclass.getActualTypeArguments()[1];
    }

    /**
     * load all instances
     */
    public List<T> loadAll() {
        return getHibernateTemplate().loadAll(persistentClass);
    }

    /**
     * query according to two properties
     */
    public List<T> getListByTwoProperty(String propertyName1, Object value1, String propertyName2, Object value2) {
        String queryString = "from " + persistentClass.getName() + " as model where model."
                + propertyName1 + " = ?  and model." + propertyName2 + " = ?";
        return (List<T>)getHibernateTemplate().find(queryString, new Object[]{value1,value2});
    }
    public List<T> getListByThreeProperty(String propertyName1, Object value1, String propertyName2, Object value2,String propertyName3, Object value3) {
        String queryString = "from " + persistentClass.getName() + " as model where model."
                + propertyName1 + " = ?  and model." + propertyName2 + " = ?and model." + propertyName3 + " = ?";
        return (List<T>)getHibernateTemplate().find(queryString, new Object[]{value1,value2,value3});
    }

    /**
     * query according to a property
     */
    public List<T> getListByProperty(String propertyName, Object value) {
        String queryString = "from " + persistentClass.getName() + " as model where model."
                + propertyName + "= ?";
        return (List<T>)getHibernateTemplate().find(queryString, value);
    }

    public T getOneByProperty(String propertyName, Object value) {
        String queryString = "from " + persistentClass.getName() + " as model where model."
                + propertyName + "= ?";
        List<T> results = (List<T>)getHibernateTemplate().find(queryString, value);
        if(results.size() == 0) {
            return null;
        }
        return ((T)results.get(0));
    }

    public T getByKey(PK key){
        return this.getHibernateTemplate().get(persistentClass, key);
    }

    public void update(T entity) {
        this.getHibernateTemplate().update(entity);
    }

    public void save(T entity){
        this.getHibernateTemplate().save(entity);
    }

    public void delete(T entity){
        this.getHibernateTemplate().delete(entity);
    }


}
