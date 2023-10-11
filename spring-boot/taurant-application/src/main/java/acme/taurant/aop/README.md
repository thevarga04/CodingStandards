### Sample output of 1 request from AOP logging
```
[nio-9194-exec-2] acme.aop.PerformanceLog : 4,61,$Proxy147.findBySinceAfterAndUntilBeforeAndSeating_Id
[nio-9194-exec-2] acme.aop.PerformanceLog : 3,63,SeatingBookingDao.assertNotPreoccupied
[nio-9194-exec-2] acme.aop.PerformanceLog : 4,1,$Proxy147.save
[nio-9194-exec-2] acme.aop.PerformanceLog : 3,2,SeatingBookingDao.save
[nio-9194-exec-2] acme.aop.PerformanceLog : 2,68,SeatingBookingServiceImpl.seatingBookingInRestaurant
[nio-9194-exec-2] acme.aop.PerformanceLog : 1,68,SeatingRest.seatingBookingInRestaurant
[ooledExecutor-1] acme.aop.PerformanceLog : 2,2005,FacepookAnalyticsDispatcher.dispatch
[ooledExecutor-1] acme.aop.PerformanceLog : 2,1012,GoobleAnalyticsDispatcher.dispatch
[ooledExecutor-1] acme.aop.PerformanceLog : 1,3018,AnalyticsDispatcherService.dispatch
```

**As we can see, static methods are not intercepted and are harder to unit test,\
so we should consider when to use them. (Simple, isolated and deterministic tasks.)**