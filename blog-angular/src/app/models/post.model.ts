import {UserModel} from './user.model';
import {CommentModel} from './comment.model';

export class PostModel {
  constructor(
    public id: number,
    public title: string,
    public content: string,
    public image?: string,


    public user?: UserModel,
    public comments?: CommentModel[],

  public created_at?: string,
  public updated_at?: string,
  ) {}
}
