# Caching in Hibernate

# Level 1 (L1) Caching
* Scope: Session
* Objects are cached within sessions
* Always on

# Level 2 (L2) Caching
* Scope: SessionFactory
* Objects can be cached across sessions
* Must configure

# 3rd Party Caching Providers
* EHCache
* OSCache
* SwarmCache
* JBoss Cache

# EHCache
* Named because it's a palindrome and it depends on a double linked list, which can be traversed forwards and backwards

# Hibernate Caching Configuration

`hibernate.cfg.xml`

```
<property name="hibernate.cache.use_second_level_cache">true</property>
<property name="hibernate.cache.region.factory_class">org.hibernate.cache.ehcache.EhCacheRegionFactory</property>
```

`ehcache.xml`

```
<ehcache>
	<cache name="myAwesomeCache" eternal="false" timeToIdleSeconds="300" timeToLiveSeconds="600"/>

    <defaultCache
            maxElementsInMemory="10000"
            eternal="false"
            timeToIdleSeconds="120"
            timeToLiveSeconds="120"
            overflowToDisk="false"
            maxElementsOnDisk="10000000"
            diskPersistent="false"
            diskExpiryThreadIntervalSeconds="120"
            memoryStoreEvictionPolicy="LRU"
    />
</ehcache>
```

`FlashCard.java`

```
package com.example.domain;

import javax.persistence.*;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="flash_card")
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY, region="myAwesomeCache")
public class FlashCard {

}
```
