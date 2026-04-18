public class FacadeOperation {

    private DiskWork disk = new DiskWork();
    private MemoryWork memory = new MemoryWork();
    private CpuWork cpu = new CpuWork();

    public int calculate(int a, int b, char op) {

        disk.searchInDisk();
        memory.checkInMemory();
        return cpu.execute(a, b, op);
    }
}
