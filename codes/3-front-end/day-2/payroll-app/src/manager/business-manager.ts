export interface BusinessManager<T, TValue> {
    add(data: T): boolean;
    fetchAll(): Readonly<T[]>;
    filterRecords(value: TValue): Readonly<T[]>;
}