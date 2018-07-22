export class UserModel {
  constructor(
    public id: number,
    public name: string,
    public username: string,
    public email: string,

    public created_at: string,
    public updated_at: string
  ) {}
}
