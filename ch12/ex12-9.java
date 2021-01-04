// java.util.concurrent 락

while (!canProceed()) { ... LockSupport.park(this); }}
