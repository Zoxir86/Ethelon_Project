package com.dao;

import com.database.Area;
import com.dto.AreaDTO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.*;

public class AreaDAOImplementation implements AreaDAO {

    private static final boolean SUCCESS = true;
    private static final boolean ERROR = false;

    private static final String PERSISTENCE_UNIT_NAME = "Ethelon";


    /********************************************************************************************************************
     Returns the area corresponding to a particular Postal Code. Returns null if nothing is found.
     *******************************************************************************************************************/

    public AreaDTO getAreaRelatedToAPostalCode(String postalCode)
    {
        initializeAreaTable();
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        AreaDTO areaDTO = null;

        String codeParam = postalCode.trim();
        codeParam = codeParam.replace(" ", "");

        try {
            Query q = em.createQuery("SELECT a FROM Area a WHERE a.postalCode LIKE :code");
            q.setParameter("code", codeParam);
            List<Area> areaList = q.getResultList();
            AreaDTO temp;

            if (areaList.size() != 0) {
                for (Area current : areaList) {
                    temp = transformAreaEntity2DTO(current);
                    temp.setDatabaseID(current.getAreaID());
                    areaDTO = temp;
                    break;                // We need only the first. A second is a mistake in the database as postal codes are generally unique.
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            factory.close();
        }

        return areaDTO;
    }


    /********************************************************************************************************************
     Returns a list of Areas whose postal code starts with some digits. Returns null if nothing is found.
     *******************************************************************************************************************/

    public ArrayList<AreaDTO> getAreasWhosePostalCodeStartsWith(String postalCodeFirstDigits)
    {
        initializeAreaTable();
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        ArrayList<AreaDTO> areaDTOList = new ArrayList<AreaDTO>();

        String codeParam = postalCodeFirstDigits.trim();
        codeParam = codeParam.replace(" ", "");
        codeParam = codeParam.concat("%");

        try {
            Query q = em.createQuery("SELECT a FROM Area a WHERE a.postalCode LIKE :code");
            q.setParameter("code", codeParam);
            List<Area> areaList = q.getResultList();
            AreaDTO temp;

            if (areaList.size() != 0) {
                for (Area current : areaList) {
                    temp = transformAreaEntity2DTO(current);
                    temp.setDatabaseID(current.getAreaID());
                    areaDTOList.add(temp);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            areaDTOList = null;
        } finally {
            em.close();
            factory.close();
        }

        return areaDTOList;
    }


    /********************************************************************************************************************
     Returns a list of Areas whose description starts with a combination of some characters. Returns null if nothing
     is found.
     *******************************************************************************************************************/

    public ArrayList<AreaDTO> getListOfAreasStartingWith(String areaFirstLetters)
    {
        initializeAreaTable();
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        ArrayList<AreaDTO> areaDTOList = new ArrayList<AreaDTO>();

        String codeParam = areaFirstLetters.trim();
        codeParam = codeParam.concat("%");

        try {
            Query q = em.createQuery("SELECT a FROM Area a WHERE a.area LIKE :code");
            q.setParameter("code", codeParam);
            List<Area> areaList = q.getResultList();
            AreaDTO temp;

            if (areaList.size() != 0) {
                for (Area current : areaList) {
                    temp = transformAreaEntity2DTO(current);
                    temp.setDatabaseID(current.getAreaID());
                    areaDTOList.add(temp);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            areaDTOList = null;
        } finally {
            em.close();
            factory.close();
        }

        return areaDTOList;
    }


    /********************************************************************************************************************
     Returns a list of Areas whose description starts contains a combination of some characters. Returns null
     if nothing is found.
     *******************************************************************************************************************/

    public ArrayList<AreaDTO> getListOfAreasContaining(String areaMiddleLetters)
    {
        initializeAreaTable();
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        ArrayList<AreaDTO> areaDTOList = new ArrayList<AreaDTO>();

        String codeParam = areaMiddleLetters.trim();
        codeParam = "%" + codeParam;
        codeParam = codeParam.concat("%");

        try {
            Query q = em.createQuery("SELECT a FROM Area a WHERE a.area LIKE :code");
            q.setParameter("code", codeParam);
            List<Area> areaList = q.getResultList();
            AreaDTO temp;

            if (areaList.size() != 0) {
                for (Area current : areaList) {
                    temp = transformAreaEntity2DTO(current);
                    temp.setDatabaseID(current.getAreaID());
                    areaDTOList.add(temp);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            areaDTOList = null;
        } finally {
            em.close();
            factory.close();
        }

        return areaDTOList;
    }


    /********************************************************************************************************************
     Returns a list of Areas who belong to a particular prefecture. Returns null if nothing is found.
     *******************************************************************************************************************/

    public ArrayList<AreaDTO> getListOfAreasOfPrefecture(String prefecture)
    {
        initializeAreaTable();
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        ArrayList<AreaDTO> areaDTOList = new ArrayList<AreaDTO>();

        String codeParam = prefecture.trim();

        try {
            Query q = em.createQuery("SELECT a FROM Area a WHERE a.prefecture LIKE :code");
            q.setParameter("code", codeParam);
            List<Area> areaList = q.getResultList();
            AreaDTO temp;

            if (areaList.size() != 0) {
                for (Area current : areaList) {
                    temp = transformAreaEntity2DTO(current);
                    temp.setDatabaseID(current.getAreaID());
                    areaDTOList.add(temp);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            areaDTOList = null;
        } finally {
            em.close();
            factory.close();
        }

        return areaDTOList;
    }


    /********************************************************************************************************************
     Returns a list of Areas who belong to a particular country. Returns null if nothing is found.
     *******************************************************************************************************************/

    public ArrayList<AreaDTO> getListOfAreasOfCountry(String country)
    {
        initializeAreaTable();
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        ArrayList<AreaDTO> areaDTOList = new ArrayList<AreaDTO>();

        String codeParam = country.trim();

        try {
            Query q = em.createQuery("SELECT a FROM Area a WHERE a.country LIKE :code");
            q.setParameter("code", codeParam);
            List<Area> areaList = q.getResultList();
            AreaDTO temp;

            if (areaList.size() != 0) {
                for (Area current : areaList) {
                    temp = transformAreaEntity2DTO(current);
                    temp.setDatabaseID(current.getAreaID());
                    areaDTOList.add(temp);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            areaDTOList = null;
        } finally {
            em.close();
            factory.close();
        }

        return areaDTOList;
    }


    /********************************************************************************************************************
     Returns the full list of Areas. Returns null if nothing is found.
     *******************************************************************************************************************/

    public ArrayList<AreaDTO> getFullListOfAreas()
    {
        initializeAreaTable();
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        ArrayList<AreaDTO> areaDTOList = new ArrayList<AreaDTO>();

        try {
            Query q = em.createQuery("SELECT a FROM Area a where 1=1 ");
            List<Area> areaList = q.getResultList();
            AreaDTO temp;

            if (areaList.size() != 0) {
                for (Area current : areaList) {
                    temp = transformAreaEntity2DTO(current);
                    temp.setDatabaseID(current.getAreaID());
                    areaDTOList.add(temp);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            areaDTOList = null;
        } finally {
            em.close();
            factory.close();
        }

        return areaDTOList;
    }


    /********************************************************************************************************************
     Returns a list of prefectures who belong to a particular country. Unique values in alphabetical order.
     Returns null if nothing is found.
     *******************************************************************************************************************/

    public ArrayList<String> getListOfPrefecturesOfCountry(String country)
    {
        initializeAreaTable();
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        ArrayList<String> areaStringList = new ArrayList<String>();

        String codeParam = country.trim();

        try {
            Query q = em.createQuery("SELECT a FROM Area a WHERE a.country LIKE :code");
            q.setParameter("code", codeParam);
            List<Area> areaList = q.getResultList();
            String temp;

            if (areaList.size() != 0) {
                for (Area current : areaList) {
                    temp = current.getPrefecture();
                    areaStringList.add(temp);
                }

                // Remove duplicates by using a little trick.
                // Transfer everything to a Set that does not allow duplicates and then back.
                Set<String> hs = new HashSet<String>();
                hs.addAll(areaStringList);
                areaStringList.clear();
                areaStringList.addAll(hs);

                // Put the prefectures in alphabetical order for aesthetic and practical reasons.
                Collections.sort(areaStringList, new Comparator<String>() {
                    public int compare(String s1, String s2) {
                        return s1.compareToIgnoreCase(s2);
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
            areaStringList = null;
        } finally {
            em.close();
            factory.close();
        }

        return areaStringList;
    }


    /********************************************************************************************************************
     Returns a full list of prefectures. Unique values in alphabetical order. Returns null if nothing is found.
     *******************************************************************************************************************/

    public ArrayList<String> getFullListOfPrefectures()
    {
        initializeAreaTable();
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        ArrayList<String> areaStringList = new ArrayList<String>();

        try {
            Query q = em.createQuery("SELECT a FROM Area a ");
            List<Area> areaList = q.getResultList();
            String temp;

            if (areaList.size() != 0) {
                for (Area current : areaList) {
                    temp = current.getPrefecture();
                    areaStringList.add(temp);
                }

                // Remove duplicates by using a little trick.
                // Transfer everything to a Set that does not allow duplicates and then back.
                Set<String> hs = new HashSet<String>();
                hs.addAll(areaStringList);
                areaStringList.clear();
                areaStringList.addAll(hs);

                // Put the prefectures in alphabetical order for aesthetic and practical reasons.
                Collections.sort(areaStringList, new Comparator<String>() {
                    public int compare(String s1, String s2) {
                        return s1.compareToIgnoreCase(s2);
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
            areaStringList = null;
        } finally {
            em.close();
            factory.close();
        }

        return areaStringList;
    }


    /********************************************************************************************************************
     Returns a full list of countries. Unique values in alphabetical order. Returns null if nothing is found.
     *******************************************************************************************************************/

    public ArrayList<String> getFullListOfCountries()
    {
        initializeAreaTable();
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        ArrayList<String> areaStringList = new ArrayList<String>();

        try {
            Query q = em.createQuery("SELECT a FROM Area a ");
            List<Area> areaList = q.getResultList();
            String temp;

            if (areaList.size() != 0) {
                for (Area current : areaList) {
                    temp = current.getCountry();
                    areaStringList.add(temp);
                }

                // Remove duplicates by using a little trick.
                // Transfer everything to a Set that does not allow duplicates and then back.
                Set<String> hs = new HashSet<String>();
                hs.addAll(areaStringList);
                areaStringList.clear();
                areaStringList.addAll(hs);

                // Put the prefectures in alphabetical order for aesthetic and practical reasons.
                Collections.sort(areaStringList, new Comparator<String>() {
                    public int compare(String s1, String s2) {
                        return s1.compareToIgnoreCase(s2);
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
            areaStringList = null;
        } finally {
            em.close();
            factory.close();
        }

        return areaStringList;
    }


    /********************************************************************************************************************
     Utility: Checks if the Area table is currently empty.
     *******************************************************************************************************************/

    private boolean checkIfAreaTableIsEmpty() {
        EntityManagerFactory factory;
        EntityManager em;
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        em = factory.createEntityManager();

        Query q = em.createQuery ("SELECT count(x) FROM Area x");
        Number result = (Number) q.getSingleResult ();

        if(result.intValue() == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }


    /********************************************************************************************************************
     Utility: If the Area table is currently empty, it populates it with fixed values.
     *******************************************************************************************************************/

    private boolean initializeAreaTable() {

        if(!checkIfAreaTableIsEmpty()) return SUCCESS;

        EntityManagerFactory factory;
        EntityManager em;
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        em = factory.createEntityManager();

        ArrayList<Area> list = Utilities.getListOfAllAreas();
        boolean result;

        try {
            em.getTransaction().begin();

            for (Area area : list) {
                em.persist(area);
            }

            em.getTransaction().commit();
            result = SUCCESS;
        } catch (Exception e) {
            em.getTransaction().rollback();
            result = ERROR;
        } finally {
            em.close();
            factory.close();
        }
        return result;
    }


    /******************************************************************************************************************
     Utility: Performs transformation from Entities (used by the JPA mechanisms) to DTO (incoming and outgoing calls).
     *****************************************************************************************************************/

    public static AreaDTO transformAreaEntity2DTO(Area entity)
    {
        AreaDTO dto = new AreaDTO();
        dto.setDatabaseID(entity.getAreaID());
        dto.setArea(entity.getArea());
        dto.setPrefecture(entity.getPrefecture());
        dto.setCountry(entity.getCountry());
        dto.setPostalCode(entity.getPostalCode());
        return dto;
    }


    /******************************************************************************************************************
     Utility: Performs transformation from DTO (incoming and outgoing calls) to Entities (used by the JPA mechanisms).
     *****************************************************************************************************************/

    public static Area transformAreaDTO2Entity(AreaDTO dto)
    {
        Area entity = new Area();
        entity.setAreaID(dto.getDatabaseID());
        entity.setArea(dto.getArea());
        entity.setPrefecture(dto.getPrefecture());
        entity.setCountry(dto.getCountry());
        entity.setPostalCode(dto.getPostalCode());
        return entity;
    }


    /******************************************************************************************************************
     Utility: Returns an Area entity as persisted in the database when the databaseID is known.
     *****************************************************************************************************************/

    public static Area findAreaById(int databaseID)
    {
        if(databaseID == 0) return null;

        Area entity;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        try {
            entity = em.find( Area.class, databaseID );
        } catch(Exception e) {
            entity = null;
        }
        finally {
            em.close();
            factory.close();
        }

        return entity;
    }
}


